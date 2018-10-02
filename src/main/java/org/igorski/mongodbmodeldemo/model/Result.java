package org.igorski.mongodbmodeldemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Document
public class Result {
    private Participant participant;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
