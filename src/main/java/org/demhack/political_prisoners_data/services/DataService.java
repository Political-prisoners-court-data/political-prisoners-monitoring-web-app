package org.demhack.political_prisoners_data.services;

import org.demhack.political_prisoners_data.entities.PoliticalPrisoner;
import org.demhack.political_prisoners_data.entities.RfmUpdateSuggestion;
import org.demhack.political_prisoners_data.entities.Update;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Stream;

public class DataService {
    public static List<PoliticalPrisoner> getPeople() {
        return Stream.of(
                new PoliticalPrisoner(1),
                new PoliticalPrisoner(2, "Иванов Иван Иваныч", "Дело Ермолаева и других в Чите", "Забайкальский край", "Краснокаменск", 64, false, new GregorianCalendar(2018, Calendar.MARCH, 12).getTime(), new GregorianCalendar(2019, Calendar.FEBRUARY, 18).getTime(), false),
                new PoliticalPrisoner(3),
                new PoliticalPrisoner(4),
                new PoliticalPrisoner(5),
                new PoliticalPrisoner(6, "Иванов Иван Иваныч", "Дело Ермолаева и других в Чите", "Забайкальский край", "Краснокаменск", 64, false, new GregorianCalendar(2018, Calendar.MARCH, 12).getTime(), new GregorianCalendar(2019, Calendar.FEBRUARY, 18).getTime(), false),
                new PoliticalPrisoner(7),
                new PoliticalPrisoner(8),
                new PoliticalPrisoner(9),
                new PoliticalPrisoner(10),
                new PoliticalPrisoner(11),
                new PoliticalPrisoner(12, "Иванов Иван Иваныч", "Дело Ермолаева и других в Чите", "Забайкальский край", "Краснокаменск", 64, false, new GregorianCalendar(2018, Calendar.MARCH, 12).getTime(), new GregorianCalendar(2019, Calendar.FEBRUARY, 18).getTime(), false),
                new PoliticalPrisoner(13),
                new PoliticalPrisoner(14))
                .sorted()
                .toList();
    }

    public static List<RfmUpdateSuggestion> getRfmUpdateSuggestions() {

        PoliticalPrisoner unknownPrisoner = new PoliticalPrisoner(
                15,
                "И",
                "",
                "Белгородская область",
                "Белгород",
                34,
                false,
                new GregorianCalendar(
                        2023,
                        Calendar.DECEMBER,
                        13)
                        .getTime(),
                null,
                false);
        var suggestion1 = new RfmUpdateSuggestion(1, unknownPrisoner);
        var suggestion2 = new RfmUpdateSuggestion(2, unknownPrisoner);
        var suggestion3 = new RfmUpdateSuggestion(3, unknownPrisoner);
        var suggestion4 = new RfmUpdateSuggestion(4, unknownPrisoner);
        var suggestion5 = new RfmUpdateSuggestion(5, unknownPrisoner);
        var suggestion6 = new RfmUpdateSuggestion(6, unknownPrisoner);

        return Stream.of(
            suggestion1, suggestion2, suggestion3, suggestion4,
                suggestion5, suggestion6
        ).toList();
    }

    public static List<Update> getUpdates() {
        PoliticalPrisoner politicalPrisoner1 = new PoliticalPrisoner(
                16,
                "Иванов Иван Иваныч",
                "",
                "Белгородская область",
                "Белгород",
                34,
                false,
                new GregorianCalendar(
                        2023,
                        Calendar.DECEMBER,
                        13)
                        .getTime(),
                null,
                false
        );

        PoliticalPrisoner politicalPrisoner2 = new PoliticalPrisoner(
                17,
                "Петров Петр Петрович",
                "",
                "Вологодская обл",
                "Вологда",
                28,
                false,
                new GregorianCalendar(
                        2023,
                        Calendar.OCTOBER,
                        15)
                        .getTime(),
                null,
                false
        );

        PoliticalPrisoner politicalPrisoner3 = new PoliticalPrisoner(
                18,
                "Денисов Денис Денисыч",
                "",
                "Ростовская область",
                "Г. Батайск",
                44,
                false,
                new GregorianCalendar(
                        2023,
                        Calendar.MARCH,
                        16)
                        .getTime(),
                null,
                false
        );

        PoliticalPrisoner politicalPrisoner4 = new PoliticalPrisoner(
                19,
                "Сергеев Сергей Сергеич",
                "",
                "Г. МОСКВА",
                "Г. МОСКВА",
                53,
                false,
                new GregorianCalendar(
                        2023,
                        Calendar.JUNE,
                        28)
                        .getTime(),
                new GregorianCalendar(
                        2024,
                        Calendar.FEBRUARY,
                        3)
                        .getTime(),
                false
        );

        var update1 = new Update(1, politicalPrisoner1, "Добавление в список РФМ", "Иванов Иван *, 14.10.1989, Г.БЕЛГОРОД");
        var update2 = new Update(2, politicalPrisoner1, "Удален из списка РФМ", "Иванов Иван *, 14.10.1989, Г.БЕЛГОРОД");
        var update3 = new Update(3, politicalPrisoner2, "Постановление приговора 231", "Суд в г. Санкт-Петербурге, Суд Невского района, 11.03.2024");
        var update4 = new Update(4, politicalPrisoner3, "Постановление приговора 4155", "Суд в г. Санкт-Петербурге, Суд Невского района, 11.01.2024" );
        var update5 = new Update(5, politicalPrisoner4, "Постановление приговора от 14.12.2023, Аппеляция", "Суд в г. Санкт-Петербурге, Суд Невского района, 11.03.2024");


        return Stream.of(
            update1, update2, update3, update4, update5
        ).toList();
    }
}
