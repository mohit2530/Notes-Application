package com.notes.notes.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Note")
public class Note {

    @Id
    private String identifier = null;
    private String note = null;
    private Date createDate = null;
    private Date modifiedDate = null;
    private boolean completed;

}
