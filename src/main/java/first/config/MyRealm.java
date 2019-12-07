package first.config;


import first.pojo.Quan;
import first.pojo.User;
import first.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by 54110 on 2019/11/22.
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    //权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String tel = (String)principals.getPrimaryPrincipal();
        List<Quan> quan = userService.findQuan(tel);
        HashSet set=new HashSet();
        if(quan!=null){
            for (Quan q:quan){
                set.add(q.getQname());
            }
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addStringPermissions(set);
            return info;
        }
        return null;
    }

    //登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String tel = (String)token.getPrincipal();
        User one = userService.findOne(tel);
        if (one!=null){

            return  new SimpleAuthenticationInfo(one.getTel(),one.getPass(),getName());
        }

        return null;
    }
}