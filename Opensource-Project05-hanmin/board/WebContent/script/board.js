//23] boardWrite.jsp에서왔다

function boardCheck(){
	if(document.frm.title.value.length==0){
		alert('제목을 입력하세요');
		frm.title.focus();
		return false;
	}
	return true;
}
//#50]수정 삭제 버튼을 눌렀을 때 호출될 함수
function open_win(url,name){
	window.open(url,name,"width=500, height=230")
}
	

function nickCheck(){
	if(document.frm.nick.value.length==0){
		alert('검색할 닉네임을 입력하세요');
		frm.nick.focus();
		return false;
	}
	return true; 
}
function passCheck() {
	if(document.frm.pass.value.length==0){
		alert('비밀번호를 입력하세요');
		return false;
	}
		return true;
		
	
}