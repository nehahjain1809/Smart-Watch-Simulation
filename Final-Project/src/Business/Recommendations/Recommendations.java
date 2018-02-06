/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Recommendations;

import Business.Person.Person;

/**
 *
 * @author nehah
 */
public class Recommendations {
    private int recommendationId;
    private Person person;
    private String recommendationDomain;
    private String recommendationDescription;
    private static int count;
    

    public Recommendations(){
        count++;
        recommendationId=count;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Recommendations.count = count;
    }
    
    
    public int getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(int recommendationId) {
        this.recommendationId = recommendationId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getRecommendationDomain() {
        return recommendationDomain;
    }

    public void setRecommendationDomain(String recommendationDomain) {
        this.recommendationDomain = recommendationDomain;
    }

    public String getRecommendationDescription() {
        return recommendationDescription;
    }

    public void setRecommendationDescription(String recommendationDescription) {
        this.recommendationDescription = recommendationDescription;
    }
    
    
    
    
}
