package org.example.library.service;

import org.example.library.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberService {

    private final List<Member> members = new ArrayList<>();

    // Add a new member
    public void addMember(Member member) {
        members.add(member);
    }

    // Get all members
    public List<Member> getAllMembers() {
        return new ArrayList<>(members);
    }

    // Find a member by ID
    public Member findMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    // Find a member by membership ID
    public Member findByMembershipId(String membershipId) {
        for (Member member : members) {
            if (member.getMembershipId().equalsIgnoreCase(membershipId)) {
                return member;
            }
        }
        return null;
    }

    // Edit an existing member
    public boolean updateMember(int id, String name, String email,
                                String membershipId) {

        Member member = findMemberById(id);

        if (member == null) {
            return false;
        }

        member.setName(name);
        member.setEmail(email);
        member.setMembershipId(membershipId);

        return true;
    }

    // Delete a member
    public boolean deleteMember(int id) {
        Member member = findMemberById(id);

        if (member == null) {
            return false;
        }

        members.remove(member);
        return true;
    }
}