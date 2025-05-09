package com.example.formuskan;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formuskan.adapter.LettersAdapter;
import com.example.formuskan.model.LetterItem;

import java.util.ArrayList;
import java.util.List;

public class LettersActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LettersAdapter adapter;
    List<LetterItem> letterList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_letters);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.lettersRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        letterList = new ArrayList<>();
        letterList.add(new LetterItem("For your Sad days",
                "achha to meri jaan aaj udaas mehsoos kr rhi hai.... to suno bacha aap chinta mat kro chahe waqt kitna bhi achha ya bura ho mai hamesha aapke sath hu.. har waqt.. kabhi akela mat mehsoos krna.. chahe aapki jindagi me kitni bhi badi problem aajaye.. shashi kant hamesha hai aapke liye...❤aur jab aap udaas hote ho na to sach kahu to mujhe bhi kuchh achha nhi lagta bacha.. saari jindagi aisi berang  lagne lagti hai  sirf aapke udaas rhne se.. aur kyu chinta krti ho aap chahe kuchh bhi hoga hamari life me hum milkr kar lenge na handle.. problems to kiski life me nhi aaati na bacha.. hum us situation me strong rhkr problems se kaise deal krte hai wo important hai.. \nChalo ab jaldi se muskura do .. aur mujhe call krlo fatafat se fir hum milkr sochenge ki kaise deal krna hai is problem se.. \n\nkabhi akela mat feel krna mera bacha.."));
        letterList.add(new LetterItem("For your happy days",
                "waah kitni pyaari lagti hai meri jaan muskurati hui.. kaash aapki jindagi ka har ek din aise hi itna hi khubsurat ho aur aap yuhi hasti raho.. kaash aapki muskurahat ko dekh kr aapse jalne wale sab log jal jal ke mar jaaye . Meri pyaari jaan, aapki muskurahat toh jaise koi anmol tohfa hai, jise dekh kar mera har din roshan ho jata hai. Aap jab hasti hain, toh aisa lagta hai jaise duniya ki saari khushiyan simat kar aapke chehre par aa gayi hain. Meri toh yahi dua hai ki aapki zindagi ka har pal isi tarah beete, har subah nayi umang lekar aaye aur har raat meethi yaadon se bhari ho. "));
        letterList.add(new LetterItem("For the days you miss me",
                "meri pyaari jaan, jab aap mujhe yaad karti ho na, toh meri rooh tak bechain ho jaati hai… jaise dil ke kisi kone mein aapki yaadon ki dhoondh chhayi ho. Har us pal mein, jab aap mujhe yaad karti ho, main khud ko aur zyada aapke kareeb mehsoos karta hoon. Kaash main us waqt aapke paas hota, aapka haath tham kar kehta, 'main hamesha yahin hoon, tumhare saath.' Aapki yaad toh meri zindagi ki sabse khoobsurat aadat ban gayi hai. Jab aap udas hoti ho, toh meri duniya bhi thodi si sooni lagti hai. Mujhe yakeen hai, ek din aayega jab yaad karne ki zarurat hi nahi padegi… kyunki main hamesha aapke paas hoon, sirf ek muskurahat ke faasle par."
        ));

        adapter = new LettersAdapter(this, letterList);
        recyclerView.setAdapter(adapter);
    }
}