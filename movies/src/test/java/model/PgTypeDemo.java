package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PgTypeDemo {

    @Test
    void demoPgType() {
        PgType pg = PgType.R;
        System.out.println(pg);

        String pgStr = "PG_13";
        PgType pg2 = PgType.valueOf(pgStr);
        assertEquals(PgType.PG_13, pg2);
        System.out.println(pg2);

        for (var pg3: PgType.values()){
            System.out.println("\t- " + pg3);
        }
    }

    @ParameterizedTest
    @EnumSource(PgType.class)
    void demoSwitchCase(PgType pg){
        System.out.println("Literal: " + pg);
        System.out.println("Ordinal: " + pg.ordinal());
        System.out.println("Name: " + pg.name());
        switch (pg) {
            case R:
                System.out.println("ça doit saigner");
                break;
            case PG_13:
                System.out.println("on y va avec les grands");
                break;
            case PG:
                System.out.println("pour toute la famille");
                break;
//            default:  // unnecessary if whole coverage
//                System.out.println("What ?");
        }
    }

    @Test
    void testEquals() {
        PgType pg1 = PgType.PG_13;
        PgType pg2 = PgType.PG_13;
        assertTrue(pg1 == pg2);
        assertTrue(pg1.equals(pg2));
    }

    @Test
    void demoSort() {
        List<PgType> pgList = List.of(PgType.PG_13, PgType.R, PgType.PG, PgType.R, PgType.PG_13);
        var pgListSorted = pgList.stream()
                .sorted()
                .toList();
        System.out.println(pgList);
        System.out.println(pgListSorted);
    }


}