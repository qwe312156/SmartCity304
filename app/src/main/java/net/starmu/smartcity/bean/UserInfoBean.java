package net.starmu.smartcity.bean;

import java.util.List;

public class UserInfoBean {

    /**
     * msg : 操作成功
     * code : 200
     * permissions : []
     * roles : []
     * user : {"searchValue":null,"createBy":"","createTime":"2021-03-17 19:42:30","updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":13361,"deptId":null,"userName":"smartcity","oldPwd":null,"nickName":"SmartCity","email":"","phonenumber":"14532894266","sex":"1","avatar":"","salt":null,"status":"0","delFlag":"0","loginIp":"","loginDate":null,"dept":null,"roles":[],"roleIds":null,"postIds":null,"idCard":null,"file":null,"admin":false}
     */

    private String msg;
    private int code;
    private UserBean user;
    private List<?> permissions;
    private List<?> roles;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public List<?> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<?> permissions) {
        this.permissions = permissions;
    }

    public List<?> getRoles() {
        return roles;
    }

    public void setRoles(List<?> roles) {
        this.roles = roles;
    }

    public static class UserBean {
        /**
         * searchValue : null
         * createBy :
         * createTime : 2021-03-17 19:42:30
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * userId : 13361
         * deptId : null
         * userName : smartcity
         * oldPwd : null
         * nickName : SmartCity
         * email :
         * phonenumber : 14532894266
         * sex : 1
         * avatar :
         * salt : null
         * status : 0
         * delFlag : 0
         * loginIp :
         * loginDate : null
         * dept : null
         * roles : []
         * roleIds : null
         * postIds : null
         * idCard : null
         * file : null
         * admin : false
         */

        private Object searchValue;
        private String createBy;
        private String createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsBean params;
        private int userId;
        private Object deptId;
        private String userName;
        private Object oldPwd;
        private String nickName;
        private String email;
        private String phonenumber;
        private String sex;
        private String avatar;
        private Object salt;
        private String status;
        private String delFlag;
        private String loginIp;
        private Object loginDate;
        private Object dept;
        private Object roleIds;
        private Object postIds;
        private Object idCard;
        private Object file;
        private boolean admin;
        private List<?> roles;

        public Object getSearchValue() {
            return searchValue;
        }

        public void setSearchValue(Object searchValue) {
            this.searchValue = searchValue;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public ParamsBean getParams() {
            return params;
        }

        public void setParams(ParamsBean params) {
            this.params = params;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public Object getDeptId() {
            return deptId;
        }

        public void setDeptId(Object deptId) {
            this.deptId = deptId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Object getOldPwd() {
            return oldPwd;
        }

        public void setOldPwd(Object oldPwd) {
            this.oldPwd = oldPwd;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhonenumber() {
            return phonenumber;
        }

        public void setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public Object getSalt() {
            return salt;
        }

        public void setSalt(Object salt) {
            this.salt = salt;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(String delFlag) {
            this.delFlag = delFlag;
        }

        public String getLoginIp() {
            return loginIp;
        }

        public void setLoginIp(String loginIp) {
            this.loginIp = loginIp;
        }

        public Object getLoginDate() {
            return loginDate;
        }

        public void setLoginDate(Object loginDate) {
            this.loginDate = loginDate;
        }

        public Object getDept() {
            return dept;
        }

        public void setDept(Object dept) {
            this.dept = dept;
        }

        public Object getRoleIds() {
            return roleIds;
        }

        public void setRoleIds(Object roleIds) {
            this.roleIds = roleIds;
        }

        public Object getPostIds() {
            return postIds;
        }

        public void setPostIds(Object postIds) {
            this.postIds = postIds;
        }

        public Object getIdCard() {
            return idCard;
        }

        public void setIdCard(Object idCard) {
            this.idCard = idCard;
        }

        public Object getFile() {
            return file;
        }

        public void setFile(Object file) {
            this.file = file;
        }

        public boolean isAdmin() {
            return admin;
        }

        public void setAdmin(boolean admin) {
            this.admin = admin;
        }

        public List<?> getRoles() {
            return roles;
        }

        public void setRoles(List<?> roles) {
            this.roles = roles;
        }

        public static class ParamsBean {
        }
    }
}
