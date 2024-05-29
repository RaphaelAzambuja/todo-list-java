package com.todolist.api.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.todolist.api.dtos.ListDTO;
import com.todolist.api.entities.ListEntity;
import com.todolist.api.repositories.ListRepository;

@Service
public class ListService {

    private ListRepository listRepository;

    public ListService(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    public List<ListEntity> findAll() {
        return listRepository.findAll();
    }

    public ListEntity findById(Long id) {
        Optional<ListEntity> list = this.listRepository.findById(id);
        return list.orElse(null);
    }

    public List<ListEntity> create(ListDTO listDTO) {
        
        ListEntity list = new ListEntity.Builder()
                            .title(listDTO.title())
                            .description(listDTO.description())
                            .build();

        listRepository.save(list);
        return findAll();
    }

    public List<ListEntity> update(ListDTO listDTO, Long id) {
        ListEntity list = findById(id);

        if (list != null) {    
            ListEntity updatedList = ListEntity.builder(list)
                                        .title(listDTO.title())
                                        .description(listDTO.description())
                                        .build();

            updatedList.setId(list.getId());
            listRepository.save(updatedList);
        }

        return findAll();
    }
    
    public List<ListEntity> delete(Long id) {
        ListEntity list = findById(id);

        if (list != null) {
            listRepository.delete(list);
        }

        return findAll();
    }
}
