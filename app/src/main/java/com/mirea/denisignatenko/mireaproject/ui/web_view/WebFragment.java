package com.mirea.denisignatenko.mireaproject.ui.web_view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.mirea.denisignatenko.mireaproject.R;

import static com.mirea.denisignatenko.mireaproject.MainActivity.SAVED_THEME;
import static com.mirea.denisignatenko.mireaproject.MainActivity.preferences_theme;

public class WebFragment extends Fragment {
    WebView webView;
    EditText editTextLink;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_web_view, container, false);
        webView = root.findViewById(R.id.web);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://web.telegram.org");
        editTextLink = root.findViewById(R.id.edit_link);

        View.OnClickListener homePageClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl("https://web.telegram.org");
            }
        };
        root.findViewById(R.id.button_home_page).setOnClickListener(homePageClickListener);

        View.OnClickListener searchClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl(editTextLink.getText().toString());
            }
        };
        root.findViewById(R.id.button_search).setOnClickListener(searchClickListener);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        getView().setBackgroundColor(preferences_theme.getInt(SAVED_THEME, getResources().getColor(R.color.alt)));
    }
}