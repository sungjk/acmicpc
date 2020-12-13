package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by jeremy on 2020/12/08.
 */
public class CourseSchedule {
    private final Map<Integer, List<Integer>> prerequisiteMap = new HashMap<>();
    private boolean[] visited;
    private boolean[] taken;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        taken = new boolean[numCourses];
        for (int[] coursePrerequisite : prerequisites) {
            // prerequisite -> list(course)
            Integer prerequisite = coursePrerequisite[1];
            Integer course = coursePrerequisite[0];
            prerequisiteMap.computeIfAbsent(prerequisite, (k) -> new ArrayList<>())
                .add(course);
        }

        return IntStream.range(0, numCourses)
            .boxed()
            .filter(course -> !visited[course])
            .filter(this::hasCycle)
            .allMatch(it -> false);
//        for (int course = 0; course < numCourses; course++) {
//            if (!visited[course] && hasCycle(course)) {
//                return false;
//            }
//        }
//        return true;
    }

    public Boolean hasCycle(int course) {
        visited[course] = true;
        // tour prerequisite class
        for (Integer prerequisite : prerequisiteMap.getOrDefault(course, Collections.emptyList())) {
            if (visited[prerequisite] && !taken[prerequisite]) {
                // ex: [1,0],[2,1],[0,2]
                // course   0  1  2
                // visited [x][x][x]
                // taken   [ ][ ][ ]
                return true;
            }
            if (!visited[prerequisite] && hasCycle(prerequisite)) {
                return true;
            }
        }
        taken[course] = true;
        return false;
    }

    public static class UnitTest {
        private final CourseSchedule cs = new CourseSchedule();

        @Test
        public void test1() {
            int numCourses = 2;
            int[][] prerequisites = new int[][] {
                {1, 0}
            };

            assertTrue(cs.canFinish(numCourses, prerequisites));
        }

        @Test
        public void test2() {
            int numCourses = 2;
            int[][] prerequisites = new int[][] {
                {1, 0},
                {0, 1}
            };

            assertFalse(cs.canFinish(numCourses, prerequisites));
        }

        @Test
        public void test3() {
            int numCourses = 3;
            int[][] prerequisites = new int[][] {
                {1, 0},
                {2, 1}
            };

            assertTrue(cs.canFinish(numCourses, prerequisites));
        }

        @Test
        public void test4() {
            int numCourses = 3;
            int[][] prerequisites = new int[][] {
                {1, 0},
                {2, 1},
                {0, 2}
            };

            assertFalse(cs.canFinish(numCourses, prerequisites));
        }

        @Test
        public void test5() {
            int numCourses = 4;
            int[][] prerequisites = new int[][] {
                {1, 0},
                {2, 0},
                {3, 0},
                {3, 1},
                {3, 2}
            };

            assertTrue(cs.canFinish(numCourses, prerequisites));
        }

        @Test
        public void test6() {
            // [[0,1],[3,1],[1,3],[3,2]]
            int numCourses = 4;
            int[][] prerequisites = new int[][] {
                {0, 1},
                {3, 1},
                {1, 3},
                {3, 2}
            };

            assertFalse(cs.canFinish(numCourses, prerequisites));
        }

        @Test
        public void test7() {
            // [[2,0],[1,0],[3,1],[3,2],[1,3]]
            int numCourses = 4;
            int[][] prerequisites = new int[][] {
                {2, 0},
                {1, 0},
                {3, 1},
                {3, 2},
                {1, 3}
            };

            assertFalse(cs.canFinish(numCourses, prerequisites));
        }
    }
}
