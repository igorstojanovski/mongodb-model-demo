package org.igorski.mongodbmodeldemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document
public class Participant {
    private String name;
    private String surname;
    private String country;
}
