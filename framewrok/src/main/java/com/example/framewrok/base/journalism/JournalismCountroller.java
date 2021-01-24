package com.example.framewrok.base.journalism;

import com.example.framewrok.base.BaseAroute;
import com.example.framewrok.base.IView;
import com.example.net.bean.JournalismBean;

import java.util.HashMap;
import java.util.List;

public class JournalismCountroller {
    public interface JournalismView extends IView{
        void onJournalismView(JournalismBean dataBeans);
    }
    public  abstract static class JournalismShow extends BaseAroute<JournalismView>{
        public abstract void NewsShow();
    }
}
