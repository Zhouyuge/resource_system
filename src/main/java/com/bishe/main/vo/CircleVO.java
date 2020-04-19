package com.bishe.main.vo;

import com.bishe.main.entity.Circle;
/**
 * @author Kirito
 * @Date 2020/2/4 19:46
 */
public class CircleVO  extends Circle {
        private String userName;

        private String userHeadPic;

        private String typeValue;

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public String getUserHeadPic() {
                return userHeadPic;
        }

        public void setUserHeadPic(String userHeadPic) {
                this.userHeadPic = userHeadPic;
        }

        public String getTypeValue() {
                return typeValue;
        }

        public void setTypeValue(String typeValue) {
                this.typeValue = typeValue;
        }
}
