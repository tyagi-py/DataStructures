# Longest Substring Without Repeating Characters
def test(s):
    visited = dict()
    cur_len = 1
    max_overall = 1
    pre_idx = 0

    visited[s[0]] = 0

    for i in range(1, len(s)):
        pre_idx = visited.get(s[i], -1)

        if pre_idx == -1 or i - cur_len > pre_idx:
            cur_len += 1

        else:

            if cur_len  > max_overall:
                max_overall = cur_len

            cur_len = i - pre_idx

        visited[s[i]] = i
    if cur_len > max_overall:
        max_overall = cur_len

    return max_overall


