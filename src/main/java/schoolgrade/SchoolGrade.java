package schoolgrade;

import schoolgrade.arithmetic.Arithmetic;
import schoolgrade.arithmetic.impl.SAFreshman;
import schoolgrade.arithmetic.impl.SASecondGrade;
import schoolgrade.arithmetic.impl.SAThirdGrade;
import schoolgrade.language.Language;
import schoolgrade.language.impl.SLFreshman;
import schoolgrade.language.impl.SLSecondGrade;
import schoolgrade.language.impl.SLThirdGrade;
import schoolgrade.science.Science;
import schoolgrade.science.impl.SSFreshman;
import schoolgrade.science.impl.SSSecondGrade;
import schoolgrade.science.impl.SSThirdGrade;

import java.util.stream.Stream;

public enum SchoolGrade {
    FRESHMAN(Integer.valueOf(1), new SAFreshman(), new SLFreshman(), new SSFreshman()),
    SECOND_GRADE(Integer.valueOf(2), new SASecondGrade(), new SLSecondGrade(), new SSSecondGrade()),
    THIRD_GRADE(Integer.valueOf(3), new SAThirdGrade(), new SLThirdGrade(), new SSThirdGrade());

    private Integer grade;
    private Arithmetic arithmetic;
    private Language language;
    private Science science;

    SchoolGrade(Integer grade, Arithmetic arithmetic, Language language, Science science) {
        this.grade = grade;
        this.arithmetic = arithmetic;
        this.language = language;
        this.science = science;
    }

    public static Arithmetic createArithmetic(Integer grade) {
        return Stream.of(SchoolGrade.values())
                .filter(v -> grade.equals(v.grade))
                .map(v -> v.arithmetic)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("未定義の学年です: %s", grade.toString())));
    }

    public static Language createLanguage(Integer grade) {
        return Stream.of(SchoolGrade.values())
                .filter(v -> grade.equals(v.grade))
                .map(v -> v.language)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("未定義の学年です: %s", grade.toString())));
    }

    public static Science createScience(Integer grade) {
        return Stream.of(SchoolGrade.values())
                .filter(v -> grade.equals(v.grade))
                .map(v -> v.science)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("未定義の学年です: %s", grade.toString())));
    }

    public Integer grade() {
        return this.grade;
    }

    public Arithmetic arithmetic() {
        return this.arithmetic;
    }

    public Language language() {
        return this.language;
    }

    public Science science() {
        return science;
    }
}
