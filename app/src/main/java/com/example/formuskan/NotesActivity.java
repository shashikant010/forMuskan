package com.example.formuskan;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formuskan.adapter.NotesAdapter;

public class NotesActivity extends AppCompatActivity {

    RecyclerView notesRecyclerView;
    String[] notes = {
            "मैं लिख दू तुम्हारी उम्र चाँद सितारों से,\n" +
                    "मैं मनाऊ जन्मदिन तुम्हारा फूल बहारों से,\n" +
                    "ऐसी खूबसूरती दुनिया से लेकर आऊ मैं,\n" +
                    "की सारी महफ़िल सज जाए हसीन नजारो से......!!!\n" +
                    "\"आपको दिल से जन्मदिन मुबारक हो",
            "फूलों ने अमृत का जाम भेजा है,\n" +
                    "सूरज ने गगन से सलाम भेजा है,\n" +
                    "मुबारक हो आपको नया जन्मदिन,\n" +
                    "तहे-दिल से हमने ये पैगाम भेजा है......!!!",
            "सूरज रौशनी ले कर आया,\n" +
                    "और चिड़ियों न गाना गाया,\n" +
                    "फूलों ने हंस हंस कर बोला,\n" +
                    "मुबारक हो तुम्हारा जन्मदिन आया.......!!",
            "उस दिन खुदा ने भी जश्न मनाया होगा,\n" +
                    "जिस दिन आपको अपने हाथो से बनाया होगा,\n" +
                    "उसने भी बहाए होंगे आंसू,\n" +
                    "जिस दिन आपको यहाँ भेज कर खुद को अकेला पाया होगा.....!!!\n" +
                    "जन्मदिन मुबारक हो",


            "दिल डूब कर रह जाता है तेरे इन आंखों के प्यालों में, ये दिल उलझ कर रह जाता है तेरे मासूम सवालों में, तुझसे बढ़ कर न कोई है और न कोई होगा, तू सबसे हसीन है सब हुस्न वालों में" ,
            "कहता है पल पल तुमसे हो कर दिल ये दिवाना, एक पल भी जाने जाना हमसे दूर नही जाना.",
            "तुम्हारी lovely आँखों ने हमें ऐसे attract किया, की सबको neglect करके, तुम्हे ही सेलेक्ट किया।",
            "पूरी हो दिल की हर ख्वाहिश आपकी, मिले खुशियों का जहां आपको, अगर आप मांगें आसमां का एक तारा, तो खुदा दे दे सारा आसमान आपको। जन्मदिन मुबारक हो!",
            "चांद रोज़ छत पर आकर इतराता बहुत था,\n" +
                    "कल रात मैंने भी उसे तेरी तस्वीर दिखा दी........!!!",
            "तु मिल गई है तो मुझ पे नाराज है खुदा,\n" +
                    "कहता है की तु अब कुछ माँगता नहीं है.....!!!",


    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        notesRecyclerView = findViewById(R.id.notesRecyclerView);
        notesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        notesRecyclerView.setAdapter(new NotesAdapter(this, notes));


    }
}