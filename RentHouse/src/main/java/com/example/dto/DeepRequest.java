package com.example.dto;

import com.example.entity.Country;
import lombok.*;

import java.util.Date;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeepRequest {
   private String name;
   private String start;
   private String finish;
   private Country location;
}
