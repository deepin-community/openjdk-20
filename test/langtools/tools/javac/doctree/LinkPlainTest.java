/*
 * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * @test
 * @bug 7021614 8273244 8200337
 * @summary extend com.sun.source API to support parsing javadoc comments
 * @modules jdk.compiler/com.sun.tools.javac.api
 *          jdk.compiler/com.sun.tools.javac.file
 *          jdk.compiler/com.sun.tools.javac.tree
 *          jdk.compiler/com.sun.tools.javac.util
 * @build DocCommentTester
 * @run main DocCommentTester LinkPlainTest.java
 */

class LinkPlainTest {
    /**
     * abc {@linkplain String} def
      */
    void simple_name() { }
/*
DocComment[DOC_COMMENT, pos:1
  firstSentence: 3
    Text[TEXT, pos:1, abc_]
    Link[LINK_PLAIN, pos:5
      reference:
        Reference[REFERENCE, pos:17, String]
      body: empty
    ]
    Text[TEXT, pos:24, _def]
  body: empty
  block tags: empty
]
*/

    /**
     * abc {@linkplain String desc} def
     */
    void simple_name_desc() { }
/*
DocComment[DOC_COMMENT, pos:1
  firstSentence: 3
    Text[TEXT, pos:1, abc_]
    Link[LINK_PLAIN, pos:5
      reference:
        Reference[REFERENCE, pos:17, String]
      body: 1
        Text[TEXT, pos:24, desc]
    ]
    Text[TEXT, pos:29, _def]
  body: empty
  block tags: empty
]
*/

    /**
     * abc {@linkplain java.lang.String desc} def
     */
    void pkg_name_desc() { }
/*
DocComment[DOC_COMMENT, pos:1
  firstSentence: 3
    Text[TEXT, pos:1, abc_]
    Link[LINK_PLAIN, pos:5
      reference:
        Reference[REFERENCE, pos:17, java.lang.String]
      body: 1
        Text[TEXT, pos:34, desc]
    ]
    Text[TEXT, pos:39, _def]
  body: empty
  block tags: empty
]
*/

    /**
     * abc {@linkplain java.lang.String#isEmpty desc} def
     */
    void method_desc() { }
/*
DocComment[DOC_COMMENT, pos:1
  firstSentence: 3
    Text[TEXT, pos:1, abc_]
    Link[LINK_PLAIN, pos:5
      reference:
        Reference[REFERENCE, pos:17, java.lang.String#isEmpty]
      body: 1
        Text[TEXT, pos:42, desc]
    ]
    Text[TEXT, pos:47, _def]
  body: empty
  block tags: empty
]
*/

    /**
     * abc {@linkplain java.lang.String#isEmpty() desc} def
     */
    void method_0_args_desc() { }
/*
DocComment[DOC_COMMENT, pos:1
  firstSentence: 3
    Text[TEXT, pos:1, abc_]
    Link[LINK_PLAIN, pos:5
      reference:
        Reference[REFERENCE, pos:17, java.lang.String#isEmpty()]
      body: 1
        Text[TEXT, pos:44, desc]
    ]
    Text[TEXT, pos:49, _def]
  body: empty
  block tags: empty
]
*/

    /**
     * abc {@linkplain java.lang.String#substring(int) desc} def
     */
    void method_1_args_desc() { }
/*
DocComment[DOC_COMMENT, pos:1
  firstSentence: 3
    Text[TEXT, pos:1, abc_]
    Link[LINK_PLAIN, pos:5
      reference:
        Reference[REFERENCE, pos:17, java.lang.String#substring(int)]
      body: 1
        Text[TEXT, pos:49, desc]
    ]
    Text[TEXT, pos:54, _def]
  body: empty
  block tags: empty
]
*/

    /**
     * abc {@linkplain java.lang.String#substring(int, int) desc} def
     */
    void method_2_args_desc() { }
/*
DocComment[DOC_COMMENT, pos:1
  firstSentence: 3
    Text[TEXT, pos:1, abc_]
    Link[LINK_PLAIN, pos:5
      reference:
        Reference[REFERENCE, pos:17, java.lang.String...#substring(int,_int)]
      body: 1
        Text[TEXT, pos:54, desc]
    ]
    Text[TEXT, pos:59, _def]
  body: empty
  block tags: empty
]
*/

    /**
     * abc {@linkplain java.util.List<T> desc} def
     */
    void pkg_name_typarams_desc() { }
/*
DocComment[DOC_COMMENT, pos:1
  firstSentence: 3
    Text[TEXT, pos:1, abc_]
    Link[LINK_PLAIN, pos:5
      reference:
        Reference[REFERENCE, pos:17, java.util.List<T>]
      body: 1
        Text[TEXT, pos:35, desc]
    ]
    Text[TEXT, pos:40, _def]
  body: empty
  block tags: empty
]
*/

    /**
     * abc {@linkplain java.lang.String##fragment desc} def
     */
    void fragment_desc() { }
/*
DocComment[DOC_COMMENT, pos:1
  firstSentence: 3
    Text[TEXT, pos:1, abc_]
    Link[LINK_PLAIN, pos:5
      reference:
        Reference[REFERENCE, pos:17, java.lang.String##fragment]
      body: 1
        Text[TEXT, pos:44, desc]
    ]
    Text[TEXT, pos:49, _def]
  body: empty
  block tags: empty
]
*/

}
