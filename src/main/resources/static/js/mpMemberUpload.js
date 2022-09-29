function checkImageType(fileName){
	
	var pattern = /jpg|gif|png|jpeg/i;
	
	return fileName.match(pattern);

}

function getFileInfo(fullName){
		
	var fileName,imgsrc, getLink;
	
	var fileLink;
	
	if(checkImageType(fullName)){
		//imgsrc = "/member/register/displayFile?fileName="+fullName;
		imgsrc = "/mypage/member/modify/displayFile?fileName="+fullName;
		fileLink = fullName.substr(14);
		
		var front = fullName.substr(0,12); // /2015/07/01/ 
		var end = fullName.substr(14);
		
		//getLink = "/member/register/displayFile?fileName="+front + end;
		getLink = "/mypage/member/modify/displayFile?fileName"+fullName;
		
	}else{
		alert("이미지 파일만 넣어주세요")
		return false;
	}
	fileName = fileLink.substr(fileLink.indexOf("_")+1);
	
	return  {fileName:fileName, imgsrc:imgsrc, getLink:getLink, fullName:fullName};
	
}


