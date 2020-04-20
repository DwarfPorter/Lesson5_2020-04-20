package ru.geekbrains.heradlik;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoatOfArmsFragment extends Fragment {

    public CoatOfArmsFragment() {
        // Required empty public constructor
    }

    // Фабричный метод создания фрагмента
    // Фрагменты рекомендуется создавать через фабричные методы.
    public static CoatOfArmsFragment create(int index) {
        CoatOfArmsFragment f = new CoatOfArmsFragment();    // создание

        // Передача параметра
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        return f;
    }

    // Получить индекс из списка (фактически из параметра)
    public int getIndex() {
        int index = getArguments().getInt("index", 0);
        return index;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Определить какой герб надо показать, и показать его
        ImageView coatOfArms = new ImageView(getContext());

        // Получить из ресурсов массив указателей на изображения гербов
        TypedArray imgs = getResources().obtainTypedArray(R.array.coatofarms_imgs);
        // Выбрать по индексу подходящий
        coatOfArms.setImageResource(imgs.getResourceId(getIndex(), -1));
        return coatOfArms;     // Вместо макета используем сразу картинку
    }
}
