package com.inf.khproject.repository;

import com.inf.khproject.entity.ApplicationBoard;
import com.inf.khproject.entity.ApplicationBoardChat;
import com.inf.khproject.entity.ApplicationBoardReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicationBoardChatRepository extends JpaRepository<ApplicationBoardChat, Long> {


    List<ApplicationBoardChat> getChatByApplicationBoardOrderByCno(ApplicationBoard applicationBoard);

}
