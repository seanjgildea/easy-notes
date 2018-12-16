package com.example.easynotes;

import com.example.easynotes.model.Note;
import com.example.easynotes.model.Owner;
import com.example.easynotes.repository.NoteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class NoteRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private NoteRepository noteRepository;

    @Test
    public void whenFindNote_thenReturnNote() {
        // given
        Set notes = new HashSet<Note>();
        Owner owner = new Owner(100L, "Sean", "Gildea", "seanjgildea@gmail.com", notes);
        Note note = new Note(10L, "todo list", "milk, eggs, butter and bread", owner);
        //entityManager.persist(owner);
        //entityManager.persist(note);
        //entityManager.flush();

        // when
        Note found = noteRepository.findByTitle("todo list");

        // then
        assertThat(found.getTitle()).isEqualTo(note.getTitle());
    }
}
