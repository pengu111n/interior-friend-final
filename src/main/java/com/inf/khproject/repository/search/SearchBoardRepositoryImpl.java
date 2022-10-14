package com.inf.khproject.repository.search;

import com.inf.khproject.entity.ApplicationBoard;
import com.inf.khproject.entity.QApplicationBoard;
import com.inf.khproject.entity.QApplicationBoardReply;
import com.inf.khproject.entity.QMember;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class SearchBoardRepositoryImpl extends QuerydslRepositorySupport implements SearchBoardRepository {

    public SearchBoardRepositoryImpl() {
        super(ApplicationBoard.class);
    }

    @Override
    public ApplicationBoard search1() {

        log.info("search1........................");

        QApplicationBoard applicationBoard = QApplicationBoard.applicationBoard;
        QApplicationBoardReply applicationBoardReply = QApplicationBoardReply.applicationBoardReply;
        QMember member = QMember.member;

        JPQLQuery<ApplicationBoard> jpqlQuery = from(applicationBoard);
        jpqlQuery.leftJoin(member).on(applicationBoard.writer.eq(member));
        jpqlQuery.leftJoin(applicationBoardReply).on(applicationBoardReply.applicationBoard.eq(applicationBoard));

        JPQLQuery<Tuple> tuple = jpqlQuery.select(applicationBoard, member.nickname, applicationBoardReply.count());
        tuple.groupBy(applicationBoard);

        log.info("---------------------------");
        log.info(tuple);
        log.info("---------------------------");

        List<Tuple> result = tuple.fetch();

        log.info(result);

        return null;
    }

    @Override
    public Page<Object[]> searchPage(String type, String keyword, Pageable pageable) {

        log.info("searchPage.............................");

        QApplicationBoard applicationBoard = QApplicationBoard.applicationBoard;
        QApplicationBoardReply applicationBoardReply = QApplicationBoardReply.applicationBoardReply;
        QMember member = QMember.member;

        JPQLQuery<ApplicationBoard> jpqlQuery = from(applicationBoard);
        jpqlQuery.leftJoin(member).on(applicationBoard.writer.eq(member));
        jpqlQuery.leftJoin(applicationBoardReply).on(applicationBoardReply.applicationBoard.eq(applicationBoard));

        //SELECT b, w, count(r) FROM Board b
        //LEFT JOIN b.writer w LEFT JOIN Reply r ON r.board = b
        JPQLQuery<Tuple> tuple = jpqlQuery.select(applicationBoard, member, applicationBoardReply.count());

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        BooleanExpression expression = applicationBoard.boardNo.gt(0L);

        booleanBuilder.and(expression);

        if(type != null){
            String[] typeArr = type.split("");
            //검색 조건을 작성하기
            BooleanBuilder conditionBuilder = new BooleanBuilder();

            for (String t:typeArr) {
                switch (t){
                    case "t":
                        conditionBuilder.or(applicationBoard.title.contains(keyword));
                        break;
                    case "c":
                        conditionBuilder.or(applicationBoard.required.contains(keyword));
                        break;
                }
            }
            booleanBuilder.and(conditionBuilder);
        }

        tuple.where(booleanBuilder);

        //order by
        Sort sort = pageable.getSort();

        //tuple.orderBy(board.bno.desc());

        sort.stream().forEach(order -> {
            Order direction = order.isAscending()? Order.ASC: Order.DESC;
            String prop = order.getProperty();

            PathBuilder orderByExpression = new PathBuilder(ApplicationBoard.class, "applicationBoard");
            tuple.orderBy(new OrderSpecifier(direction, orderByExpression.get(prop)));

        });
        tuple.groupBy(applicationBoard);

        //page 처리
        tuple.offset(pageable.getOffset());
        tuple.limit(pageable.getPageSize());

        List<Tuple> result = tuple.fetch();

        log.info(result);

        long count = tuple.fetchCount();

        log.info("COUNT: " +count);

        return new PageImpl<Object[]>(
                result.stream().map(t -> t.toArray()).collect(Collectors.toList()),
                pageable,
                count);
    }
}
