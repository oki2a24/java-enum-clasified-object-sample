import schoolgrade.SchoolGrade;
import schoolgrade.arithmetic.Arithmetic;
import schoolgrade.language.Language;
import schoolgrade.science.Science;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // 算数をすべて扱ってみる
        System.out.println("<<<<< 算数をすべて扱ってみる >>>>>");
        List<Arithmetic> arithmeticList = Arrays.asList(
                SchoolGrade.createArithmetic(SchoolGrade.FRESHMAN.grade()),
                SchoolGrade.createArithmetic(SchoolGrade.SECOND_GRADE.grade()),
                SchoolGrade.createArithmetic(SchoolGrade.THIRD_GRADE.grade())
        );
        arithmeticList.stream()
                .forEach(v -> System.out.println(v.printTest()));

        System.out.println("<<<<< 一年生の国語を扱ってみる >>>>>");
        Language fl = SchoolGrade.createLanguage(SchoolGrade.FRESHMAN.grade());
        System.out.println(fl.startWriting());

        System.out.println("<<<<< 三年生の理科を扱ってみる >>>>>");
        // 外部から学年が渡されてきても、学年を判定する必要なし
        Integer arg = Integer.valueOf(3);
        Science science = SchoolGrade.createScience(arg);
        System.out.println(science.makeFire());

        System.out.println("<<<<< 列挙の要素名からメソッドを呼び出し >>>>>");
        System.out.println("<<<<< FRESHMAN >>>>>");
        SchoolGrade freshman = SchoolGrade.valueOf("FRESHMAN");
        System.out.println(freshman.grade());
        System.out.println(freshman.arithmetic().printTest());
        System.out.println(freshman.language().startWriting());
        System.out.println(freshman.science().makeFire());
    }
}
