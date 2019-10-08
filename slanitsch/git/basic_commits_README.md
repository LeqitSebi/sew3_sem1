# Git Kata: Basic Commits
This kata will introduce you to the commands `git add` and `git commit`.

You can look at the bottom of this file, if you have not yet done basic git configuration.

## Setup:

1. Run `. setup.sh` (or `.\setup.ps1` in PowerShell)

## The task

1. Use `git status` to see which branch you are on.
    On branch master
2. What does `git log` look like?
    fatal: your current branch 'master' does not have any commits yet
3. Create a file
4. What does the output from `git status` look like now?
    Untracked files:
  (use "git add <file>..." to include in what will be committed)

	test.txt
5. `add` the file to the staging area
    git add test.txt
6. How does `git status` look now?
       Changes to be committed:
  (use "git rm --cached <file>..." to unstage)

	new file:   test.txt
7. `commit` the file to the repository
    git commit -m "first commit"
8. How does `git status` look now?
    nothing to commit, working tree clean
9. Change the content of the file you created earlier
10. What does `git status` look like now?
    modified:   test.txt #in red
11. `add` the file change
    git add test.txt
12. What does `git status` look like now?
    modified:   test.txt #in green
13. Change the file again
14. Make a `commit`
15. What does the `status` look like now? The `log`?
    modified:   test.txt #in red

    commit 54db61e7a1956bf6515befa4d4441126b9215107 (HEAD -> master)
    Author: slanitsch <7225@htl.rennweg.at>
    Date:   Tue Oct 8 12:45:29 2019 +0200

        second commit

    commit 5a93970a161b6d56c6a77113f67b80b2d949abbf
    Author: slanitsch <7225@htl.rennweg.at>
    Date:   Tue Oct 8 12:42:20 2019 +0200

        first commit

16. Commit the newest change
git commit -m "final commit"


## Useful commands
- `git add`
- `git commit`
- `git commit -m "My commit message"`
- `git log`
- `git log -n 5`
- `git log --oneline`
- `git log --oneline --graph`
- `touch filename` to create a file (or `sc filename ''` in PowerShell)
- `echo content > file` to overwrite file with content (or `sc filename 'content'` in PowerShell)
- `echo content >> file` to append file with content (or `ac filename 'content'` in PowerShell)


## Git Initial Configuration
1. `git config --global user.name "John Doe"`
1. `git config --global user.email "johndoe@example.com`

For the vim scared:
- `git config --global core.editor nano`

For the windows peeps:
- `git config --global core.editor notepad`

Other editor options:
- `git config --global core.editor "atom --wait"`
- `git config --global core.editor "'C:/Program Files/Notepad++/notepad++.exe' -multiInst"`
