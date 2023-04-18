package com.gpt.model;

/**
 * https://platform.openai.com/docs/models/gpt-3-5
 */
public enum Model {
    //4
    GPT_FOUR("gpt-4"),
    GPT_FOUR_0314("gpt-4-0314"),
    GPT_FOUR_32K("gpt-4-32k"),
    GPT_FOUR_32K_0314("gpt-4-32k-0314"),

    //3.5
    GPT_THREE_POINT_FIVE_TURBO("gpt-3.5-turbo"),
    GPT_THREE_POINT_FIVE_TURBO_0301("gpt-3.5-turbo-0301"),
    GPT_THREE_POINT_FIVE_DAVINCI_003("text-davinci-003"),
    GPT_THREE_POINT_FIVE_TEXT_DAVINCI_002("text-davinci-002"),
    GPT_THREE_POINT_FIVE_CODE_DAVINCI_002("code-davinci-002");

    String description;

    Model(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }
}
