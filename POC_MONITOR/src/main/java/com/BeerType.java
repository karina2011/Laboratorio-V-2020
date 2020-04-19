package com;
import lombok.Data;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class BeerType {
    private String name;
    private List ingredientes;
}
