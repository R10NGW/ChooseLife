package com.example.cs3270a7_ryanmcclain;

import android.net.Uri;
import android.os.Bundle;
import com.example.cs3270a7_ryanmcclain.db.Course;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements deleteDialog.deleteDialogFragmentListener,CourseDetailsDialogFragment.onCourseDetailsDialogFragmentListener,
        SupporterDB.SupporterDBFragmentListener,Topics.TopicsFragmentListener,video.VideoFragmentListener,Laws.LawsFragmentListener,Science.ScienceFragmentListener,Operation.OperationFragmentListener
,Why.WhyFragmentListener,Stats.StatsFragmentListener,DebatePoints.DebatePointsFragmentListener,PlannedPC.PlannedPCFragmentListener, Sources.PlannedPOFragmentListener,Development.DevelopmentFragmentListener
,Help.HelpFragmentListener, Women.TempFragmentListener,Choice.ChoiceFragmentListener,Body.BodyFragmentListener,Cercumstance.CercumstanceFragmentListener, Rape.RapeFragmentListener,ImposingView.ImposingViewFragmentListener
,IllegalAbortion.IllegalAbortionFragmentListener,Men.MenFragmentListener,Gender.GenderFragmentListener,Blank.BlankFragmentListener{
    boolean deleteAnswer;
    Course course;
    Fragment selectedFragment = null;
    FragmentManager fm;
    String selectFragmentString = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fm = getSupportFragmentManager();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }

    BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    switch (menuItem.getItemId()){
                        case R.id.nav_beASupporter:
                            hideMainMenu();

                            selectedFragment = new SupporterDB();
                            break;

                        case R.id.nav_aboutMe:
                            hideMainMenu();
                            selectFragmentString = "Main";
                            selectedFragment = new AboutMe();
                            break;

                        case R.id.nav_topics:
                            hideMainMenu();
                            selectFragmentString = "Main";
                            selectedFragment = new Topics();
                            break;
                    }

                        actionToSendFragment();
                    return true;
                }
            };

    public void toEditFragment(){
        boolean notNew = false;
        fm.beginTransaction()
                //.remove(Objects.requireNonNull(fm.findFragmentById(R.id.)))
                .add(android.R.id.content,new NewSupporterDialogFragment())
                .commit();
    }

    @Override
    public void sendBundle(Bundle bundle) {    }

    @Override
    public void setString2() {
        selectFragmentString = "Main";
    }

    @Override
    public void setString() {
        selectFragmentString = "other";
    }


    @Override
    public void sendDelete(boolean b) {
        deleteAnswer = b;
    }

    @Override
    public Course getItemToDelete() {
        return course;
    }

    @Override
    public boolean getConfirmDelete() {
        Log.d("delete", "coming through: ");
        deleteDialog dD = new deleteDialog();
        dD.setCancelable(true);
        dD.show(getSupportFragmentManager(),"delete");
        return deleteAnswer;
    }

    @Override
    public void sendPKtoDel(Course courseFrom) {
        deleteDialog dD = new deleteDialog();
        dD.setCancelable(true);
        dD.show(getSupportFragmentManager(),"delete");
        course = courseFrom;

    }
    //from supporterDB starts creation of new supporter
    @Override
    public void createNewSupporter() {
        selectFragmentString = "other";
                fm.beginTransaction()
                        .add(android.R.id.content,new NewSupporterDialogFragment())
                        .addToBackStack(null)
                        .commit();
    }
    public void hideMainMenu(){

        TextView title = findViewById(R.id.txtTitle);
        TextView bottom = findViewById(R.id.bottomText);
        ImageView ultrasound = findViewById(R.id.imgUltrasound);
        title.setVisibility(View.GONE);
        bottom.setVisibility(View.GONE);
        ultrasound.setVisibility(View.GONE);

    }

    @Override
    public void sendToVideo() {
        selectFragmentString = "Toppic";
        selectedFragment = new video();
        actionToSendFragment();

    }

    @Override
    public void sendTowhy() {
        selectFragmentString = "Toppic";
        selectedFragment = new Why();
        actionToSendFragment();
    }

    @Override
    public void sendToScience() {
        selectFragmentString = "Toppic";
        selectedFragment = new Science();
        actionToSendFragment();
    }

    @Override
    public void sendToOperation() {
        selectFragmentString = "Toppic";
        selectedFragment = new Operation();
        actionToSendFragment();

    }

    @Override
    public void sendToLaws() {
        selectFragmentString = "Toppic";
        selectedFragment = new Laws();
        actionToSendFragment();
    }

    @Override
    public void sendToStats() {
        selectFragmentString = "Toppic";
        selectedFragment = new Stats();
        actionToSendFragment();
    }

    @Override
    public void sendToDebatePoints() {
        selectFragmentString = "Toppic";
        selectedFragment = new DebatePoints();
        actionToSendFragment();

    }

    @Override
    public void sendToPlannedPC() {
        selectFragmentString = "Toppic";
        selectedFragment = new PlannedPC();
        actionToSendFragment();
    }

    @Override
    public void sendToPlannedPO() {
        selectFragmentString = "Toppic";
        selectedFragment = new Sources();
        actionToSendFragment();
    }

    @Override
    public void sendToDevelopment() {
        selectFragmentString = "Toppic";
        selectedFragment = new Development();
        actionToSendFragment();
    }

    @Override
    public void sendToHelp() {
        selectFragmentString = "Toppic";
        selectedFragment = new Help();
        actionToSendFragment();
    }

    @Override
    public void sendToTemp() {
        selectFragmentString = "Toppic";
        selectedFragment = new Women();
        actionToSendFragment();
    }
    @Override
    public void onBackPressed() {

        if(selectFragmentString == "Toppic" ){
            selectFragmentString = "Main";
            selectedFragment = new Topics();
            actionToSendFragment();
        }else if (selectFragmentString == "Debate"){
            selectFragmentString = "Toppic";
            selectedFragment = new DebatePoints();
            actionToSendFragment();
        }else if (selectFragmentString == "Main"){
            TextView title = findViewById(R.id.txtTitle);
            TextView bottom = findViewById(R.id.bottomText);
            ImageView ultrasound = findViewById(R.id.imgUltrasound);
            title.setVisibility(View.VISIBLE);
            bottom.setVisibility(View.VISIBLE);
            ultrasound.setVisibility(View.VISIBLE);
            selectedFragment = new Blank();
        actionToSendFragment();
    }
        else {super.onBackPressed();
        }

    }


    public void actionToSendFragment(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, selectedFragment)
                .commit();
    }

    @Override
    public void playVideo() {
        VideoView videoView = findViewById(R.id.video_view);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.videoabort;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        ImageView videoCover = findViewById(R.id.imgVideoCover);
        videoCover.setVisibility(View.GONE);
    }

    @Override
    public void sendToRape() {
        selectFragmentString = "Debate";
        selectedFragment = new Rape();
        actionToSendFragment();
    }

    @Override
    public void sendToBody() {
        selectFragmentString = "Debate";
        selectedFragment = new Body();
        actionToSendFragment();
    }

    @Override
    public void sendToChoice() {
        selectFragmentString = "Debate";
        selectedFragment = new Choice();
        actionToSendFragment();
    }

    @Override
    public void sendToGender() {
        selectFragmentString = "Debate";
        selectedFragment = new Gender();
        actionToSendFragment();
    }

    @Override
    public void sendToIllegalAbortion() {
        selectFragmentString = "Debate";
        selectedFragment = new IllegalAbortion();
        actionToSendFragment();
    }

    @Override
    public void sendToImposingView() {
        selectFragmentString = "Debate";
        selectedFragment = new ImposingView();
        actionToSendFragment();
    }

    @Override
    public void sendToMen() {
        selectFragmentString = "Debate";
        selectedFragment = new Men();
        actionToSendFragment();
    }

    @Override
    public void sendToCircumstances() {
        selectFragmentString = "Debate";
        selectedFragment = new Cercumstance();
        actionToSendFragment();
    }

    @Override
    public void toToppics() {

    }


}
