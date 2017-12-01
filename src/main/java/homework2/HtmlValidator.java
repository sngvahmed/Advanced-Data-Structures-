package homework2;

import java.io.IOException;
import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {

    public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
        Stack<HtmlTag> htmlTag = new Stack<HtmlTag>();
        while (tags.size() != 0) {
            HtmlTag tag = tags.poll();
            if (!tag.isSelfClosing()) {
                if (tag.isOpenTag())
                    htmlTag.add(tag);
                else {
                    if (htmlTag.empty()) {
                        return null;
                    }
                    if (!tag.matches(htmlTag.peek())) {
                        return htmlTag;
                    }
                    htmlTag.pop();
                }
            }
        }
        return htmlTag; // this line is here only so this code will compile if you don't modify it
    }

    public static void main(String args[]) {
        try {
            Queue<HtmlTag> tags = new HtmlReader().getTagsFromHtmlFile("other/test6.html");
            System.out.println(isValidHtml(tags));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

