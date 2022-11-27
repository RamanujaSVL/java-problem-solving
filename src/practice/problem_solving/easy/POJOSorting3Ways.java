package practice.problem_solving.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Candidate implements Comparable<Candidate> {

    int candidateId;
    String candidateName;

    Candidate(int candidateId, String candidateName) {
        this.candidateId = candidateId;
        this.candidateName = candidateName;
    }

    @Override
    public int compareTo(Candidate o) {
        return this.candidateId - o.candidateId;
    }
}

class CandidateNameComparator implements Comparator<Candidate> {

    @Override
    public int compare(Candidate o1, Candidate o2) {
        return o1.candidateName.compareTo(o2.candidateName);
    }
}

class CandidateManualIdSort {

    public List<Candidate> listOfCandidatesSortedById(List<Candidate> listOfCandidates) {
        for(int i = 0; i < listOfCandidates.size(); i++) {
            for(int j = i + 1; j < listOfCandidates.size(); j++){
                if(listOfCandidates.get(i).candidateId > listOfCandidates.get(j).candidateId){
                    Candidate tempCandidate = listOfCandidates.get(i);
                    listOfCandidates.set(i, listOfCandidates.get(j));
                    listOfCandidates.set(j, tempCandidate);
                }
            }
        }
        return listOfCandidates;
    }
}



public class POJOSorting3Ways {

    public static void main(String[] args) {

        List<Candidate> candidates = new ArrayList<Candidate>();
        Candidate c1 = new Candidate(2, "ABC");
        Candidate c2 = new Candidate(3, "XYZ");
        Candidate c3 = new Candidate(1, "DEF");

        candidates.add(c1);
        candidates.add(c2);
        candidates.add(c3);

        //Sorting Using Comparable defined in POJO
        Collections.sort(candidates);
        candidates.stream().forEach(can -> System.out.println("ID-"+can.candidateId+" Name-"+can.candidateName));
        System.out.println("----------------------------");
        //Sorting Using Comparator for Name
        Collections.sort(candidates, new CandidateNameComparator());
        candidates.stream().forEach(can -> System.out.println("ID-"+can.candidateId+" Name-"+can.candidateName));
        System.out.println("----------------------------");
        //Manual Sorting Bubble Sort to sort based on ID
        candidates = new CandidateManualIdSort().listOfCandidatesSortedById(candidates);
        candidates.stream().forEach(can -> System.out.println("ID-"+can.candidateId+" Name-"+can.candidateName));

    }
}
