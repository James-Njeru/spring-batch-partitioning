package com.example.batch_project.partition;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import java.util.HashMap;
import java.util.Map;

public class CustomerPartitioner implements Partitioner {

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {
        int min = 1, max = 100000;
        int targetSize = (max - min + 1) / gridSize;
        System.out.println("targetSize :: " + targetSize);
        Map<String, ExecutionContext> result = new HashMap<>();

        int number = 0, start = min;

        for (int i = 0; i < gridSize; i++) {
            ExecutionContext value = new ExecutionContext();
            int end = start + targetSize - 1;

            if (i == gridSize - 1) {
                end = max; // Ensure the last partition covers any remaining items
            }

            value.put("minValue", start);
            value.put("maxValue", end);

            result.put("partition" + number, value);
            System.out.println("Partition " + number + ": start=" + start + " end=" + end);

            start = end + 1;
            number++;
        }
        System.out.println("Partition result :: "+result.toString());
        return result;
    }
}
