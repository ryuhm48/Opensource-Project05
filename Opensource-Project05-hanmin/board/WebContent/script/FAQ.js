
// 23. FAQWrite.jsp 에서 유효성 검사하러 옴
function FAQCheck() {
	
	if(document.frm.title.value.length ==0) {
		alert('제목을 입력해주세요.');
		frm.title.focus();
		return false;
	}

	if(document.frm.content.value.length == 0){
		alert('내용을 입력해주세요.');
		frm.content.focus();
		return false;
	}
	
	// 24. 유효성 검사 마친 후 FAQWrite.jsp 로 이동
	//		-> FAQWrite.jsp
	return true;

}

function deleteCheck(num,nick,title){
		alert("nick");
	   var url = "FAQservlet?command=FAQ_delete_form&num="+num+"&nick="+nick+"&title="+title;

	   var setting = "toolbar=no, menubar=no, scrollbars=yes, resizable=no,"+ "width=450, height=200";
	   
	   window.open(url, "_blank_2", setting);
	}
/*
function deleteCheck() {
//	<script language=javascript> self.window.alert("해당 질문글을 삭제하였습니다."); location.href="FAQservlet?command=FAQ_list"; </script> 
}
*/