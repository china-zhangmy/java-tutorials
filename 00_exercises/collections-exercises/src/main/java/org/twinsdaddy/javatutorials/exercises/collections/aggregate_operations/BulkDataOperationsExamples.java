package org.twinsdaddy.javatutorials.exercises.collections.aggregate_operations;

/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

import org.twinsdaddy.javatutorials.exercises.collections.Person;

import java.util.List;

public class BulkDataOperationsExamples {
    
    public static void main(String... args) {
        
        // Create sample data

        List<Person> roster = Person.createRoster();
        
        // 1. Print names of members, for-each loop
        
        System.out.println("Members of the collection (for-each loop):");
        for (Person p : roster) {
            System.out.println(p.getName());
        }
        
        // 2. Print names of members, forEach operation
        
        System.out.println("Members of the collection (bulk data operations):");
        roster
            .stream()
            .forEach(e -> System.out.println(e.getName()));
            
        // 3. Print names of male members, forEach operation

        System.out.println(
            "Male members of the collection (bulk data operations):");
        roster
            .stream()
            .filter(e -> e.getGender() == Person.Sex.MALE)
            .forEach(e -> System.out.println(e.getName()));
            
        // 4. Print names of male members, for-each loop 

        System.out.println("Male members of the collection (for-each loop):");
        for (Person p : roster) {
            if (p.getGender() == Person.Sex.MALE) {
                System.out.println(p.getName());
            }
        }
         
        // 5. Get average age of male members of the collection:
        
        double average = roster
            .stream()
            .filter(p -> p.getGender() == Person.Sex.MALE)
            .mapToInt(Person::getAge)
            .average()
            .getAsDouble();
            
        System.out.println(
            "Average age of male members (bulk data operations): " +
            average);
    }
}
