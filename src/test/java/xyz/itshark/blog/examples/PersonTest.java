package xyz.itshark.blog.examples;

import junitparams.JUnitParamsRunner;
import junitparams.NamedParameters;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class PersonTest {

    @Test(expected = RuntimeException.class)
    public void fistNameNull() {
        Person p = new Person(null,"dummyLast");
    }

    @Test(expected = RuntimeException.class)
    @Parameters({ " " ,"  ", "   ", "    "})
    public void fistNameParameters(String param) {
        Person p = new Person(param,"dummyLast");
    }

    @Test(expected = RuntimeException.class)
    @Parameters({ " " ,"    ",
            "  ","",
            "   ", "  ",
            "    "," "})
    public void fistNameLastNameParameters(String first, String last) {
        Person p = new Person(first, last);
    }

    @Test(expected = RuntimeException.class)
    @Parameters({ " |    " , "  |", "   |  ", "    | "})
    public void fistNameLastNameParameters2(String first, String last) {
        Person p = new Person(first, last);
    }

    @Test(expected = RuntimeException.class)
    @Parameters(named = "emptyStrings")
    public void namedParameters(String first, String last) {
        Person p = new Person(first, last);
    }

    @NamedParameters("emptyStrings")
    private Object[] emptyStrings() {
        return new Object[]{
                new Object[]{null, ""},
                new Object[]{"", null},
                new Object[]{" ", "  "},
                new Object[]{"   ", " "}
        };
    }

}
