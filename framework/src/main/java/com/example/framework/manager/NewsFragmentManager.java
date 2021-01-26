package com.example.framework.manager;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class NewsFragmentManager {
    private static volatile NewsFragmentManager manager;
    private List<Fragment> allFragments=new ArrayList<>();
    private List<Fragment> visibleFragments=new ArrayList<>();
    private List<String> allTags=new ArrayList<>();
    private List<String> visibleTags=new ArrayList<>();
    private IOnFragmentChangeListener listener;
    public static NewsFragmentManager getInstance(){
        synchronized (NewsFragmentManager.class){
            if(manager==null){
                manager=new NewsFragmentManager();
            }
        }
        return manager;
    }
    private NewsFragmentManager() {

    }
    public void addFragment(String tag,Fragment fragment){
        allFragments.add(fragment);
        visibleFragments.add(fragment);
        allTags.add(tag);
        visibleTags.add(tag);
        listener.onChange();
    }
    public void deleteFragment(int index){
        visibleTags.remove(index);
        visibleFragments.remove(index);
        listener.onChange();
    }
    public void bindListener(IOnFragmentChangeListener listener) {
        this.listener = listener;
    }
    public void unbindListener(){
        listener=null;
    }
    public List<Fragment> getVisibleFragments() {
        return visibleFragments;
    }

    public List<String> getAllTags() {
        return allTags;
    }

    public List<Fragment> getAllFragments() {
        return allFragments;
    }

    public List<String> getVisibleTags() {
        return visibleTags;
    }

    public interface IOnFragmentChangeListener{
        void onChange();
    }
}

