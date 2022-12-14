package travelator

/**
 * data 변경자
 * 컴파일러가 사용자가 정의하지 않은 equals, hashCode, toString 메서드를 자동으로 대신 생성해준다.
 *
 * (한계)
 * 컴파일러가 데이터 클래스 객체의 모든 프로퍼티 값을 그대로 복사한 새 객체를 생성하되,
 * 원하면 일부를 다른 값으로 대체할 수 있는 copy() 메서드도 생성한다.
 *
 * val post = customerEmail.copy(localPart = "postmaster")
 * localPart 만 다른 값으로 변경할 수 있다.
 * 불변조건을 유지해야하는 상황에서 이는 캡슐화를 제공하지 않는다.
 */
data class EmailAddress( // 주생성자 안에서 프로퍼티 선언
    val localPart: String, // val : 불변
    val domain: String // 비공개 필드와 getxxx() 접근자 메서드를 생성해준다.
) {

    override fun toString() = "$localPart@$domain"

    // static 변수/메서드 관리
    companion object {
        /**
         * @JvmStatic
         * 클래스를 코틀린으로 바꿔도 다른 곳에서 정적 메서드 호출 코드를 변경할 필요가 없다.
         */
        @JvmStatic
        fun parse(value: String): EmailAddress =
            value.splitAroundLast('@').let { (leftPart, rightPart) ->
                EmailAddress(leftPart, rightPart)
            }
    }
}

private fun String.splitAroundLast(divider: Char): Pair<String, String> =
    lastIndexOf(divider).let { index ->
        require(index >= 1 && index != length - 1) {
            "string must be two non-empty parts separated by $divider"
        }
        substring(0, index) to substring(index + 1)
    }

