function join(){
	location.href="MemberServlet?command=join_form";
}
function updateCheck(){
	if(document.frm.name.value.length == ""){
		alert('이름을 입력하세요');
		frm.name.focus();
		return false;
	}
	if(document.frm.pwd.value.length == ""){
		alert('비번을 입력하세요');
		frm.pwd.focus();
		return false;
	}
	if(document.frm.pwd.value != document.frm.pwdCheck.value){
		alert('비번이 일치하지 않습니다.');
		frm.pwdCheck.focus();
		return false;
	}
	if(document.frm.nick.value.length == ""){
		alert('닉네임을 입력하세요');
		frm.nick.focus();
		return false;
	}
	if(document.frm.phone.value.length == ""){
		alert('전화번호를 입력하세요');
		frm.phone.focus();
		return false;
	}
	if(document.frm.age.value.length == ""){
		alert('나이를 입력하세요');
		frm.age.focus();
		return false;
	}
	return true;
	
}
function joinCheck(){
	if(document.frm.id.value.length == 0){
		alert('id를 입력하세요');
		frm.id.focus();
		return false;
	}
	if(document.frm.name.value.length == 0){
		alert('이름을 입력하세요');
		frm.name.focus();
		return false;
	}
	if(document.frm.id.value.length < 4){
		alert('id를 4글자 이상 입력하세요');
		frm.id.focus();
		return false;
	}
	if(document.frm.pwd.value.length == 0){
		alert('비번을 입력하세요');
		frm.pwd.focus();
		return false;
	}
	if(document.frm.pwd.value != document.frm.pwdCheck.value){
		alert('비번이 일치하지 않습니다.');
		frm.pwdCheck.focus();
		return false;
	}
	if(document.frm.reid.value.length == 0){
		alert('중복체크를 해야 합니다.');
		frm.id.focus();
		return false;
	}
	if(document.frm.nick.value.length == 0){
		alert('닉네임을 입력하세요');
		frm.nick.focus();
		return false;
	}
	if(document.frm.phone.value.length == 0){
		alert('전화번호를 입력하세요');
		frm.phone.focus();
		return false;
	}
	if(document.frm.age.value.length == 0){
		alert('나이를 입력하세요');
		frm.age.focus();
		return false;
	}
	return true;
}

function idCheck(){
	if(document.frm.id.value == ""){
		alert("아이디를 입력해 주세요.");
		document.frm.id.focus();
		return ;
	}
	
	var url ="MemberServlet?command=id_check&id="+document.frm.id.value;
	var setting = "toolbar=no, menubar=no, scrollbars=yes, resizable=no,"+
	"width=450, height=200";
	
	window.open(url, "_blank_1", setting);
	
}

function idOk(id){
	
	opener.frm.id.value = id;
	opener.frm.reid.value = id;
	self.close();

	
}
