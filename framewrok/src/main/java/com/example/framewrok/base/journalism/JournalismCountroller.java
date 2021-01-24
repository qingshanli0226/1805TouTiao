package com.example.framewrok.base.journalism;

import com.example.framewrok.base.BaseAroute;
import com.example.framewrok.base.IView;
import com.example.framewrok.base.view.LoadingPage;
import com.example.net.bean.JournalismBean;

import java.util.HashMap;
import java.util.List;

public class JournalismCountroller {
    public interface JournalismView extends IView{
        void onJournalismView(JournalismBean dataBeans);
    }
    public  abstract static class JournalismShow extends BaseAroute<JournalismView>{
<<<<<<< HEAD
        public abstract void NewsShow();
=======
        public abstract void NewsShow(String s, String url, HashMap<String,String> map, LoadingPage loadingPage);
>>>>>>> one
    }
}
