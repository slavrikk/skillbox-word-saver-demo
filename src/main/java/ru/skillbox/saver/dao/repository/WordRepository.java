package ru.skillbox.saver.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skillbox.saver.dao.entity.WordEntity;

import java.util.UUID;

public interface WordRepository extends JpaRepository<WordEntity, UUID> {
}
