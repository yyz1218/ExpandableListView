package android.esports.zzdj.com.expandablelistview.bean;

/**
 * anthor yaoyaozhong // FIXME: 2018/8/1
 */
public class ItemBean {
    private String GameName;
    private String logo;
    private boolean isCheck;

    public ItemBean() {
    }

    public ItemBean(String gameName, String logo, boolean isCheck) {
        GameName = gameName;
        this.logo = logo;
        this.isCheck = isCheck;
    }

    public String getGameName() {
        return GameName;
    }

    public void setGameName(String gameName) {
        GameName = gameName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    @Override
    public String toString() {
        return "ItemBean{" +
                "GameName='" + GameName + '\'' +
                ", logo='" + logo + '\'' +
                ", isCheck=" + isCheck +
                '}';
    }
}
