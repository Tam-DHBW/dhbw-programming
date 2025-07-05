package dhbw.mos.media_library;

import java.util.Date;
import java.util.List;

public record Person(String name, String surname, Date birthday, List<Work> works) {
}
