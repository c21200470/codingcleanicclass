package a21200470.mycodingcleanic;

public class ContributorModel {

    String login;
    String html_url;

    int contributions;

    @Override
    public String toString() {
        return login + "(" + contributions + ")";
    }

}