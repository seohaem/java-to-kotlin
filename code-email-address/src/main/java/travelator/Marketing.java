package travelator;

public class Marketing {

    /**
     * 자바 코드에서 코틀린 프로퍼티의 getDomain() 사용
     * @param address
     * @return
     */
    public static boolean isHotmailAddress(EmailAddress address) {
        return address.getDomain().equalsIgnoreCase("hotmail.com");
    }
}