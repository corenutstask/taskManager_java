package com.corenuts.dto;

import java.util.List;

import lombok.Data;

@Data
public class TopicDTO {

	
    private Integer task_id;

private String topic_name;

private String sub_topic_name;


private List<Integer> assingment_id;
}
