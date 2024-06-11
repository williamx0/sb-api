package com.okta.developer.sb_api.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {

    Group findByName(String name);

    List<Group> findAllUserId(String id);

}
