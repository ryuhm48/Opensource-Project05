package com.login.service;
import java.util.List;
 
//서비스는 셔틀이 될수 도 있음 ㅋ
import com.board.dao.UserDAO;
import com.login.beans.UserBean;
 
//얘는 멤버 Dao를 사용해야함
public class UserService {
    private UserDAO userDao;
//    싱글턴 패턴 적용
    public UserService(){
        userDao = UserDAO.getInstance();
    }

//    id에 해당하는 정보를 가져다 주는 기능(파라미터 id, 리턴 회원정보셋)
//    입력받은 id에 해당하는 데이터들을 갖다 주기
//    셔틀역할
    public UserBean getUserBean(String userId)
    {
        return userDao.selectOne(userId);
    }
    
//    회원정보를 수정해주는 기능(파라미터 회원정보셋)
//    회원정보셋의 id에 해당하는 데이터를 디비에서찾아서 그 pw가 회원정보셋의 pw와 일치한다면 
//    해당데이터의 name, email을 파라미터로 넘어온 회원정보셋의 name, email로 수정
    public boolean update(String userId, String pwd, String name, String email)
    {//회원정보 쪼로로로 받아서
        UserBean user = new UserBean();
        user.setUserId(userId);
        user.setPwd(pwd);
        user.setName(name);
        user.setEmail(email);
        UserBean originUserBean = userDao.selectOne(userId);
        if(originUserBean.getPwd().equals(user.getPwd())) //비밀번호가 맞으면 
        {
            userDao.updateMember(user);
            return true;
        }
        else
            return false;
    }
    
//    모든 회원정보리스트를 갖고 오는 기능(파라미터 x, 리턴 회원정보셋의 배열)
//    모든 회원정보리스트를 갖고오기
    public List<UserBean> getUserList()
    {
        return userDao.selectAll();
    }
}
