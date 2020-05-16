package lectures;

import beans.Person;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Lecture1 {

    @Test
    public void imperativeApproach() throws IOException {
        List<Person> people = MockData.getPeople();
        // 1. Find people aged less or equal 18
        // 2. Then change implementation to find first 10 people
        List<Person> people1 = new ArrayList<>();
        int counter = 0;
        for (Person person : people) {
            if (counter < 10) {
                if (person.getAge() <= 18) {
                    people1.add(person);
                    counter++;
                }
            } else break;
        }
        for (Person person : people1) {
            System.out.println(person.getAge());
        }
    }

    @Test
    public void declarativeApproachUsingStreams() throws Exception {
        ImmutableList<Person> people = MockData.getPeople();
        Predicate<Person> personPredicate = person -> person.getAge() <= 18;
        people.stream()
                .filter(personPredicate)
                .limit(10)
                .forEach(System.out::println);
    }
}
