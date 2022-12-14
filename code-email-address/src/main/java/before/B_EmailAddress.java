package before;

import java.util.Objects;

public class B_EmailAddress {
    private final String localPart; // <1> 불변 final 변수
    private final String domain;

    public static B_EmailAddress parse(String value) { // <2> 정적 팩터리 메서드
        var atIndex = value.lastIndexOf('@');
        if (atIndex < 1 || atIndex == value.length() - 1)
            throw new IllegalArgumentException(
                    "EmailAddress must be two parts separated by @"
            );

        // 주 생성자 호출
        return new B_EmailAddress(
                value.substring(0, atIndex),
                value.substring(atIndex + 1)
        );
    }

    public B_EmailAddress(String localPart, String domain) { // <3> 생성자에서 초기화
        this.localPart = localPart;
        this.domain = domain;
    }

    public String getLocalPart() { // <4> 클래스의 프로퍼티를 구성하는 접근자 메서드
        return localPart;
    }

    public String getDomain() { // <4> 클래스의 프로퍼티를 구성하는 접근자 메서드
        return domain;
    }

    @Override
    public boolean equals(Object o) { // <5> 모든 필드가 같을때 두 인스턴스 값이 같다고 판정한다
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        B_EmailAddress that = (B_EmailAddress) o;
        return localPart.equals(that.localPart) &&
                domain.equals(that.domain);
    }

    @Override
    public int hashCode() { // <5>
        return Objects.hash(localPart, domain);
    }

    @Override
    public String toString() { // <6> 표준 전자 우편 주소 형식으로 돌려준다
        return localPart + "@" + domain;
    }
}
