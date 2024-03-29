package com.note_share_res_api.backend_rest_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.note_share_res_api.backend_rest_api.modesl.*;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    Optional<Note> findById(Integer id);

    Page<Note> findByUid(String ownerId, Pageable pageable);

    @Query(value = "SELECT * FROM Note n WHERE n.approved = true", nativeQuery = true)
    Page<Note> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM Note n where n.uid = :ownerId AND n.approved = true", nativeQuery = true)
    List<Note> getDownloadCount(@PathVariable String ownerId);

    @Query(value = "SELECT * FROM Note n WHERE lower(n.title) LIKE CONCAT('%', :query, '%') AND n.approved = true", nativeQuery = true)
    Page<Note> searchNotes(String query, Pageable pageable);
}
