Github CI/CD
Follow these steps to create a PAT: https://docs.github.com/en/github/authenticating-to-github/keeping-your-account-and-data-secure/creating-a-personal-access-token
Add the following scopes: https://docs.github.com/en/packages/learn-github-packages/about-permissions-for-github-packages#about-scopes-and-permissions-for-package-registries
Copy down token somewhere secure
Follow the steps here to add the token to your maven settings: https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry

For Docker locally:
docker login docker.pkg.github.com -u USERNAME -p TOKEN

Need a token with permissions:
repo, write:packages, read:packages


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

Other useful links
https://docs.github.com/en/actions/reference/authentication-in-a-workflow#using-the-github_token-in-a-workflow


Deleting old packages: https://github.com/marketplace/actions/delete-package-versions#delete-oldest-x-number-of-versions-of-a-package-hosted-in-the-same-repo-as-the-workflow
Lab: https://lab.github.com/githubtraining/github-actions:-publish-to-github-packages
Glide repo with automation: https://github.com/bumptech/glide
Look into github pages for documentation: https://guides.github.com/features/pages/

Configuring jobs: https://docs.github.com/en/actions/reference/workflow-syntax-for-github-actions#jobs
Workflow syntax: https://docs.github.com/en/actions/reference/workflow-syntax-for-github-actions#on

## Github Workflow ideas
Triggers: push, pull_request, scheduled, page builds (github pages), releases (published, created, prereleased, released)

On pull request:
- Clone repo

- Check formatting with `formatter:format`

- Remove `-SNAPSHOT` from version
- Bump up version based on branch name, except if explicitly overridden

- Build package
- Run unit tests

- Run integration tests

- Deploy package to github maven repository
- Build associated package for api changes and push

On push:
- Clone repo

- Build package
- Run unit tests

On release:
- Clone repo

- Check formatting with `formatter:format`

- Build package
- Run unit tests

- Run integration tests

- Deploy to AWS environment
https://github.com/actions/starter-workflows/blob/0c715d6fe2fb18fcbdeb32a8a8315353b4cf320f/ci/aws.yml


## Cool ideas from course
Managing branches?
Can persist data between jobs using artifacts: https://github.com/actions/upload-artifact, https://docs.github.com/en/actions/guides/storing-workflow-data-as-artifacts
Approval workflows? Automating approvals and pull request workflow







