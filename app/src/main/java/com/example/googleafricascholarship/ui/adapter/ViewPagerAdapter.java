package com.example.googleafricascholarship.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.googleafricascholarship.ui.fragment.learining.LearningFragment;
import com.example.googleafricascholarship.ui.fragment.skills.SkillsFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LearningFragment();
            case 1:
                return new SkillsFragment();
        }
        return null;

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Learning Leaders";
            case 1:
                return "Skill IQ Learning";
            default:
                return null;
        }
    }
}
