package main.service;

import main.api.response.SettingsResponse;
import main.model.GlobalSetting;
import main.repository.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class SettingsService
{
    @Autowired
    private SettingsRepository settingsRepository;

    public SettingsResponse getSettings()
    {
        Map<String, GlobalSetting> globalSettingHashMap = new HashMap<>();
        Iterable<GlobalSetting> globalSettingIterable = settingsRepository.findAll();

        for (GlobalSetting globalSetting : globalSettingIterable)
        {
            globalSettingHashMap.put(globalSetting.getCode(),globalSetting);
        }

        GlobalSetting globalSetting = null;
        if (!globalSettingHashMap.containsKey("MULTIUSER_MODE"))
        {
            globalSetting = new GlobalSetting("MULTIUSER_MODE","Многопользовательский режим","NO");
            globalSettingHashMap.put("MULTIUSER_MODE",globalSetting);
            settingsRepository.save(globalSetting);
        }
        if (!globalSettingHashMap.containsKey("POST_PREMODERATION"))
        {
            globalSetting = new GlobalSetting("POST_PREMODERATION","Премодерация постов","NO");
            globalSettingHashMap.put("POST_PREMODERATION",globalSetting);
            settingsRepository.save(globalSetting);
        }
        if (!globalSettingHashMap.containsKey("STATISTICS_IS_PUBLIC"))
        {
            globalSetting = new GlobalSetting("STATISTICS_IS_PUBLIC","Показывать всем статистику блога","NO");
            globalSettingHashMap.put("STATISTICS_IS_PUBLIC",globalSetting);
            settingsRepository.save(globalSetting);
        }

        SettingsResponse settingsResponse = new SettingsResponse();
        settingsResponse.setMultiuserMode(globalSettingHashMap.get("MULTIUSER_MODE").getValue().equals("YES"));
        settingsResponse.setPostPremoderation(globalSettingHashMap.get("POST_PREMODERATION").getValue().equals("YES"));
        settingsResponse.setStatisticIsPublic(globalSettingHashMap.get("STATISTICS_IS_PUBLIC").getValue().equals("YES"));
        return settingsResponse;
    }
}
